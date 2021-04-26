<%--
  Created by IntelliJ IDEA.
  User: Sharath
  Date: 26-04-2021
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Hello text encrypt</title>
</head>
<body>
<%@include file="index.jsp" %>
<div class="card mx-5 my-5" >
    <div class="card-body">
        <h5 class="card-title">Text Encryption</h5>
        <form name="text-encrypt-form" method="post" class="needs-validation" onsubmit="return validateForm()"  action="${pageContext.request.contextPath}/TextEncryptServlet" novalidate>
            <div class="form-floating mb-3" >
                <textarea name="text-encrypt" class="form-control" placeholder="Enter Input Text here" id="floatingTextarea" style="height: 100px"></textarea>
                <label for="floatingTextarea">Input Text</label>
            </div>
            <div class="form-floating">
                <input name="floatingKey" type="password" class="form-control" id="floatingKey" placeholder="123456">
                <label for="floatingKey">Secret Key</label>
            </div>
            <button type="submit" class="btn btn-primary mt-4" >Submit</button>
        </form>
    </div>
</div>
<div class="card mx-5 my-5" >
    <div class="card-body">
        <h5 class="card-title">Encrypted Text</h5>
        <%
            Object attributeValue = request.getAttribute("encrypted_text");
            if(attributeValue == null) {
                attributeValue = "";
            }

        %>
        <form method="get">
            <textarea class="form-control" placeholder="Output Text" id="floatingTextarea1" disabled readonly style="height: 100px"><%= attributeValue%></textarea>
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
        var key = document.forms["text-encrypt-form"]["floatingKey"].value;
        var text = document.forms["text-encrypt-form"]["text-encrypt"].value;
        var keyField = document.getElementById("floatingKey");
        var textField = document.getElementById("floatingTextarea");

        if(key.length === 0 && text.length === 0) {
            if(textField.classList.contains("is-valid")){
                textField.classList.remove("is-valid");
            }
            textField.classList.add("is-invalid");

            if(keyField.classList.contains("is-valid")){
                keyField.classList.remove("is-valid");
            }
            keyField.classList.add("is-invalid");
            return false;
        }

        if (key.length === 16) {
            if(keyField.classList.contains("is-invalid")){
                keyField.classList.remove("is-invalid");
            }
            keyField.classList.add("is-valid");
        }

        if(text.length > 0) {
            if(textField.classList.contains("is-invalid")){
                textField.classList.remove("is-invalid");
            }
            textField.classList.add("is-valid");
        }

        if(text.length === 0) {
            if(textField.classList.contains("is-valid")){
                textField.classList.remove("is-valid");
            }
            textField.classList.add("is-invalid");
            return false;
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
