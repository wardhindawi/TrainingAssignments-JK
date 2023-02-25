function fullFormValidation(){
    if(nameValidation()){
        return;
    }
    
    var pronouns = document.getElementById('pronouns').value;
    if(nullValidation(pronouns)){
        alert("Preferred Pronouns should not be empty");
        return;
    }

    if(validateEmail()){
        alert("Email is invalid");
        return;
    }

    var workPhone = document.getElementById('workPhone').value;
    if(nullValidation(workPhone)){
        alert("Work Phone should not be empty");
        return;
    }else if(isNaN(workPhone)){
        alert("Work Phone should be numeric");
        return;
    }

    var cellPhone = document.getElementById('cellPhone').value;
    if(isNaN(cellPhone)){
        alert("Cell Phone should be numeric");
        return;
    }
    
    var jobTitle = document.getElementById('jobTitle').value;
    if(textValidation(jobTitle)){
        alert("job Title should be text")
        return;
    }
    
    var company = document.getElementById('company').value;
    if(nullValidation(company)){
        alert("Company name should not be empty")
        return;
    }else if(textValidation(company)){
        alert("Company name should be text")
        return;
    }
    
    var address = document.getElementById('address').value;
    if(nullValidation(address)){
        alert("Address should not be empty")
        return;
    }
    
    var companyWebSite = document.getElementById('companyWebSite').value;
    if(isURLValid(companyWebSite)){
        alert("Company website url is not valid");
        return;
    }

    var facebookURL = document.getElementById('facebookURL').value;
    if(isURLValid(facebookURL)){
        alert("Facebook website url is not valid");
        return;
    }

    try{
        console.log(document.querySelector('input[name="radioGroup"]:checked').value)
    }catch{
        alert("Sponsorship level is required");
        return;
    }

    alert("form is submitted successfully");
    
}

function nameValidation(){
    var fName = document.getElementById('fName').value;
    var lName = document.getElementById('lName').value;
    if(nullValidation(fName)){
        alert("First Name should not be empty")
        return true;
    }else if(nullValidation(lName)){
        alert("Last Name should not be empty")
        return true;
    }else if(textValidation(fName)){
        alert("First Name should be text")
        return true;
    }else if(textValidation(lName)){
        alert("Last Name should be text")
        return true;
    } 
    return false;

}

function textValidation(value) {
    var letters = /^[A-Za-z]+$/;
    if(value.match(letters)){
        return false;
    }else{
        return true;
    }
}

function isURLValid(value){
    let matchURL = /(https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|www\.[a-zA-Z0-9][a-zA-Z0-9-]+[a-zA-Z0-9]\.[^\s]{2,}|https?:\/\/(?:www\.|(?!www))[a-zA-Z0-9]+\.[^\s]{2,}|www\.[a-zA-Z0-9]+\.[^\s]{2,})/gi;
    if(value.match(matchURL)){
        return false;
    }else{
        return true;
    }

}

function validateEmail(){
    var emailValue = document.getElementById('email').value;
    if(nullValidation(emailValue)){
        alert("email should not be null");
        return true;
    }else{  
        var email = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        if(emailValue.match(email)){
            return false;
        }else{
            return true;
        }
    }
}

function nullValidation(value) {
    if(value == ""){
        return true;
    }else{
        return false;
    }
}