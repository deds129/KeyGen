function myFunction() {
    console.log('hfdf')
    var x = document.getElementById("pwdInput");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}

function copyToClipboard1(element) {
    try {
        var $temp = $("<input>");
        $("body").append($temp);
        $temp.val($(element).text()).select();
        var retVal = document.execCommand("copy");
        console.log('Copied content: ' + retVal);
        console.log('Copy to clipboard returns: ' + $(element).text());
        $temp.remove();
    } catch (err) {
        console.log('Error while copying to clipboard: ' + err);
    }
}

//works
function copytext(text) {
    var textField = document.createElement('textarea');
    textField.innerText = text;
    document.body.appendChild(textField);
    textField.select();
    textField.focus(); //SET FOCUS on the TEXTFIELD
    document.execCommand('copy');
    textField.remove();
    console.log('should have copied ' + text);
    ajax - error.focus(); //SET FOCUS BACK to MODAL
}

function copyToClipboard2(elementId) {
    var aux = document.createElement("input");
    aux.setAttribute("value", document.getElementById(elementId).innerHTML);
    console.log(aux.getAttribute("value"));
    aux.focus();
    document.body.appendChild(aux);
    aux.select();
    console.log(aux)
    document.execCommand('copy');
    aux.remove();
    document.body.removeChild(aux);
}



