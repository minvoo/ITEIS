function check() {

    const passwordInput = document.getElementById("password");
    const confirmPasswordInput = document.getElementById("confirmPassword");
    const submitBtn = document.getElementById("submitBtn");

    if (passwordInput.value == confirmPasswordInput.value) {
        confirmPasswordInput.classList.remove("is-invalid");
        confirmPasswordInput.classList.add("is-valid");
        submitBtn.disabled = false;

    } else {

        confirmPasswordInput.classList.remove("is-valid");
        confirmPasswordInput.classList.add("is-invalid");
        submitBtn.disabled = true;
    }

    if (confirmPasswordInput.value.length == 0) {
        confirmPasswordInput.classList.remove("is-invalid");
        confirmPasswordInput.classList.remove("is-valid");
        submitBtn.disabled = true;
    }
}