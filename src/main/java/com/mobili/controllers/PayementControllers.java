package com.mobili.controllers;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.stellar.sdk.AssetTypeNative;
import org.stellar.sdk.KeyPair;
import org.stellar.sdk.Memo;
import org.stellar.sdk.Network;
import org.stellar.sdk.PaymentOperation;
import org.stellar.sdk.Server;
import org.stellar.sdk.Transaction;
import org.stellar.sdk.responses.AccountResponse;
import org.stellar.sdk.responses.SubmitTransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobili.models.Payement;
import com.mobili.models.Utilisateur;
import com.mobili.payload.request.PayementRequest;
import com.mobili.payload.response.MessageResponse;
import com.mobili.repository.PayementRepository;
import com.mobili.repository.UtilisateurRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/payement")
public class PayementControllers {
	@Autowired
	private PayementRepository payementRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	EntityManager entityManager;
   
   
   //RECURER TOUS LES PAYEMENTS d'un UTILISATEUR
   @GetMapping("/payements/{utilisateurId}")
   @PreAuthorize("hasRole('USER') or hasRole('ADMIN')or hasRole('MODERATEUR')")
   public Collection<Payement> getAllPayementRecus(@PathVariable(value = "utilisateurId") int utilisateurId){
		Utilisateur user = utilisateurRepository.findUserById(utilisateurId);
			return payementRepository.findByBeneficiaireOrDestinateur(user, user);
	    } 
   
   //ENREGISTREMENT D'UN PAYEMENT
   @PostMapping("/ajoutpayement")
   public ResponseEntity<?> payement(@Valid @RequestBody PayementRequest payementRequest) throws IOException{
	   Utilisateur destinateur = utilisateurRepository.findUserById(payementRequest.getDestinateurId());
	   Utilisateur beneficiaire = utilisateurRepository.findUserById(payementRequest.getBeneficiaireId());
	   
	   Server server = new Server("https://horizon-testnet.stellar.org");
	   KeyPair source = KeyPair.fromSecretSeed(destinateur.getStellarsecret());
	   KeyPair destination = KeyPair.fromAccountId(beneficiaire.getStellarid());
	
	   
	   server.accounts().account(destination.getAccountId());
	   
	   AccountResponse sourceAccount = server.accounts().account(source.getAccountId());
	   
	   Transaction transaction = new Transaction.Builder(sourceAccount, Network.TESTNET)
		        .addOperation(new PaymentOperation.Builder(destination.getAccountId(), new AssetTypeNative(), payementRequest.getMontant()).build())
		        .setBaseFee(100)
		        // A memo allows you to add your own metadata to a transaction. It's
		        // optional and does not affect how Stellar treats the transaction.
		        .addMemo(Memo.text("Test Transaction"))
		        // Wait a maximum of three minutes for the transaction
		        .setTimeout(180)
		        .build();
		// Sign the transaction to prove you are actually the person sending it.
		transaction.sign(source);
		// And finally, send it off to Stellar!
		try {
		  SubmitTransactionResponse response = server.submitTransaction(transaction);
		  System.out.println("Success!");
		  System.out.println(response);
		} catch (Exception e) {
		  System.out.println("Something went wrong!");
		  System.out.println(e.getMessage());
		  // If the result is unknown (no response body, timeout etc.) we simply resubmit
		  // already built transaction:
		  // SubmitTransactionResponse response = server.submitTransaction(transaction);
		}
	   
	   Date date = new Date();
	   
	   Payement payement = new Payement(
			   date,
			   "ToDO : génerer un titre ",
			   payementRequest.getCommentaire(),
			   payementRequest.getMontant(),
			   payementRequest.getFrais()
			   );
	   payement.setDestinateur(destinateur);
	   payement.setBeneficiaire(beneficiaire);
	   payementRepository.save(payement);
	   
	   return ResponseEntity.ok(new MessageResponse("Transfert de " + payement.getMontant() +" envoyé à : " + beneficiaire.getNom() + " " + beneficiaire.getPrenom()));
   }
   
}
