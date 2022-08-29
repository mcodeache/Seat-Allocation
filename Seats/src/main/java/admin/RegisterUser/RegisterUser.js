var myInput = Document.getElementById("psw");
    var letter = Document.getElementById("letter");
    var capital = Document.getElementById("capital");
    var number = Document.getElementById("number");
    var length = Document.getElementById("length");

    myInput.onfocus = function(){
        document.getElementById("message").style.display = "block";
    }

    muInput.onblur = function(){
        document.getElementById("message").style.display = "none";
    } 

    myInput.onkeyup = function()
    {
        var lowercaseLetters = /[a-z]/g;
        if(myInput.value.match(lowercaseLetters))
        {
            letter.classList.remove("invalid");
            letter.classList.add("valid");
        }
        else
        {
            letter.classList.remove("valid");
            letter.classList.add("invalid");
        }

        var uppercaseLetters = /[A-Z]/g;
        if(myInput.value.match(uppercaseLetters))
        {
            letter.classList.remove("invalid");
            letter.classList.add("valid");
        }
        else
        {
            letter.classList.remove("valid");
            letter.classList.add("invalid");
        }

        var numbers = /[0-9]/g;
        if(myInput.value.match(numbers))
        {
            numbers.classList.remove("invalid");
            letter.classList.add("valid");
        }
        else
        {
            letter.classList.remove("valid");
            letter.classList.add("invalid");
        }

        if(myInput.value.length >= 8){
            length.classList.remove("invalid");
            letter.classList.add("valid");
        }
        else
        {
            letter.classList.remove("valid");
            letter.classList.add("invalid");
        }

    }

