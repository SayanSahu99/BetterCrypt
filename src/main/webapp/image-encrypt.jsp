<%--
  Created by IntelliJ IDEA.
  User: Sharath
  Date: 26-04-2021
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Hello image encrypt</title>
</head>
<body>
<%@include file="index.jsp" %>
<div class="card mx-5 my-5" >
    <div class="card-body">
        <h5 class="card-title">Image Encryption</h5>
        <form name="image-encrypt-form" method="post" class="needs-validation" onsubmit="return validateForm()"  action="${pageContext.request.contextPath}/ImageEncryptServlet" novalidate>
            <div class="input-group mb-3">
                <input type="file" class="form-control" id="inputGroupFile02">
            </div>
            <div class="form-floating">
                <input name="floatingKey" type="password" class="form-control" id="floatingKey" placeholder="123456">
                <label for="floatingKey">Secret Key</label>
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
        var key = document.forms["image-encrypt-form"]["floatingKey"].value;
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
