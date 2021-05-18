<%--
  Created by IntelliJ IDEA.
  User: Sharath
  Date: 26-04-2021
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Image decryption</title>
    <link rel="icon" type="image/x-icon" href="assets/BetterCryptLogo.ico" />
</head>
<body>
<%@include file="header.jsp" %>
<div class="card mx-5 my-5" >
    <div class="card-body">
        <h5 class="card-title">Image Decryption</h5>
        <form name="image-decrypt-form" method="post" class="needs-validation" onsubmit="return validateForm()" enctype="multipart/form-data" action="${pageContext.request.contextPath}/ImageDecryptServlet" novalidate>
            <div class="input-group mb-3">
                <input name="file" type="file" class="form-control" id="inputGroupFile02" accept="image/*">
            </div>
            <div class="form-floating mb-3">
                <input name="floatingKey" type="password" class="form-control" id="floatingKey" placeholder="123456">
                <label for="floatingKey">Secret Key</label>
            </div>
            <div class="input-group mb-3">
                <select class="form-select" aria-label="Default select example">
                    <option value="128">128 Bit</option>
                    <option value="256">256 Bit</option>
                </select>
            </div>
            <button type="submit" class="btn btn-primary mt-4" >Submit</button>
        </form>
    </div>
</div>
<script>
    'use strict'

    var forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!validateForm()) {
                    event.stopPropagation()
                    event.preventDefault()
                }
            }, false)
        })

    function validateForm() {
        var key = document.forms["image-decrypt-form"]["floatingKey"].value;
        var keyField = document.getElementById("floatingKey");

        if (key.length === 16) {
            if(keyField.classList.contains("is-invalid")){
                keyField.classList.remove("is-invalid");
            }
            keyField.classList.add("is-valid");
        }
        if((key === "") || (key.length !== 16)){
            if(keyField.classList.contains("is-valid")){
                keyField.classList.remove("is-valid");
            }
            keyField.classList.add("is-invalid");
            return false;
        }
        else {
            return true;
        }
    }
</script>
</body>
</html>
