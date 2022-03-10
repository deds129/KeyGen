function myFunction() {
    console.log('hfdf')
    var x = document.getElementById("pwdInput");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}