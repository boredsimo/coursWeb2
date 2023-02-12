/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    $(document).ready( function(){
         
         $("#signupForm").validate(
                 {
                     
                   rules: {
                                        status : "required",
					prenom: "required",
					nom: "required",
					
					password: {
						required: true,
						minlength: 5
					},
					confirm_password: {
						required: true,
						minlength: 5,
						equalTo: "#password"
					},
					email: {
						required: true,
                                                email:true
						
					},
					formation : "required",
			              Commentaire : "required"
				},
				messages: {
                                        status: "Veuillez cocher votre status",
					prenom: "Veuillez saisir votre prenom",
					nom: "Veuillez saisir votre nom",
					identifiant: {
						required: "Veuillez saisir votre identifiant",
						minlength: "Votre identifiant doit contenir au moins deux characters"
					},
					password: {
						required: "Veuillez saisir votre mot de passe",
						minlength: "Votre mot de passe doit contenir au moins 5 characters"
					},
					confirm_password: {
						required: "Veuillez saisir votre mot de passe",
						minlength: "Votre identifiant doit contenir au moins 5 characters",
						equalTo: "Veuillez saisir le meme mot de passe que précédent"
					},
					email: { required : "Veuillez saisir un email "
                                                
                                              },
			               formation: "Choisissez une formation",
			               Commentaire : "Saisissez un commentaire"
				},
                    errorElement:"em"
                     
                     
                     
                     
                 } );
                 
                 
                    //La méthode on() attache un ou plusieurs gestionnaires d'événements
                    //pour pour les éléments sélectionnés
                    //ici on v disactive le bouton submit si le formulaire
                    // n'est pas valide
                     $('input').on('blur', function () {
                         //verifi si le formulaire est valide
                        if ($("#signupForm").valid()) {
                           // Activer le bouton submit : ajoutez propriété disabled a  false
                            $('#submit').prop('disabled', false);
                        } else {
                            //Desactiver le bouton submit: met la proprieté disabled à disabled
                            $('#submit').prop('disabled', 'disabled');
                        }
                    });
        
    });
            
       //une méthode qui permet de verifier si le champ mot de passe correspond au pattern spécifié
	jQuery.validator.addMethod(
			  "password",
			  function(value){
				  return  /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/.test(value) ;
			  },
			  'Le mot de passe doit contenir : au moins une lettre minuscule,au moins une lettre majuscule, au moins un chiffre,au moins huit caractères ' 
		     
			  
	);


//une méthode qui permet de verifier si le champ email correspond au pattern spécifié
	
jQuery.validator.addMethod(
  "email",
  function (courriel) {
    /*
    // // Fonction qui reçoit un courriel vérifie que ca commence par une lettre
// que des lettres et des points et des tirets sans accents
// (plus restrictif que la vraie spécification)
   
    */
    var patron = /^[a-z][a-z0-9]*((\.|\-)?[a-z0-9]+)*@([a-z0-9]+\.)+[a-z]+$/i;
    return patron.test(courriel.trim());

  },
  "Rentrez un email valide"
);


    
      

