<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Sharath
  Date: 26-04-2021
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Text encryption</title>
    <link rel="icon" type="image/x-icon" href="assets/BetterCryptLogo.ico" />
</head>
<body>
<%@include file="header.jsp" %>
<%
    Object success = request.getAttribute("success");
    if(success != null) {
        out.println("<html lang=\"en\">\n" +
                "<head>\n" +
                "    <!-- Compiled and minified CSS -->\n" +
                "    <link href=\"//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css\" rel=\"stylesheet\" />\n" +
                "    <title></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<!-- Compiled and minified JavaScript -->\n" +
                "<script src=\"//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js\" ></script>\n" +
                "<script src=\"//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js\"></script>\n" +
                "<script>toastr.success(\" "+success+"\", \"Success\");</script>\n" +
                "</body>\n" +
                "</html>");
    }
%>
<div class="card border-dark shadow-lg mx-5 my-5" >
    <h5 class="card-header text-white bg-dark">Text Encryption</h5>
    <div class="card-body">
        <form name="text-encrypt-form" method="post" class="needs-validation" onsubmit="return validateForm()"  action="${pageContext.request.contextPath}/TextEncryptServlet" novalidate>
            <div class="form-floating mb-3" >
                <textarea name="text-encrypt" class="form-control border-dark" placeholder="Enter Input Text here" id="floatingTextarea" style="height: 200px"></textarea>
                <label for="floatingTextarea">Input Text</label>
            </div>
            <div class="input-group mb-3">
                <select name="bits" class="form-select border-dark" aria-label="Default select example">
                    <option value="128">128 Bits</option>
                    <option value="192">192 Bits</option>
                    <option value="256">256 Bits</option>
                </select>
            </div>
            <div class="form-floating mb-3">
                <input name="floatingKey" type="password" class="form-control border-dark" id="floatingKey" placeholder="123456">
                <label for="floatingKey">Secret Key</label>
            </div>
            <button type="submit" class="btn btn-lg btn-primary mt-4" >Submit</button>
        </form>
    </div>
</div>
<div class="card border-dark shadow-lg mx-5 my-5" >
    <h5 class="card-header text-white bg-dark">Encrypted Text</h5>
    <div class="card-body">
        <%
            Object attributeValue = request.getAttribute("encrypted_text");
            if(attributeValue == null) {
                attributeValue = "";
            }

        %>
        <form method="get">
            <textarea class="form-control border-dark" placeholder="Output Text" id="floatingTextarea1" disabled readonly style="height: 200px"><%= attributeValue%></textarea>
        </form>
    </div>
</div>
<div class="card border-dark shadow-lg mx-5 my-5" >
    <h5 class="card-header text-white bg-dark">Generate Random Key</h5>
    <div class="card-body">
        <form >
            <input class="form-control border-dark" placeholder="Sample Key" id="floatingTextarea2" disabled readonly>
            <button type="button" class="btn btn-lg btn-primary mt-4" onclick="generateUUID()" >Generate Key</button>
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

    function showToast() {
        console.log("Toast ");
        toastr.success('message', 'title');
    }

    function generateUUID()
    {
        var d = new Date().getTime();
        var keyField = document.getElementById("floatingTextarea2");
        var keyField1 = document.getElementById("floatingKey");
        if( window.performance && typeof window.performance.now === "function" )
        {
            d += performance.now();
        }

        var uuid = 'xxx-xxx-4xx-yxxx'.replace(/[xy]/g, function(c)
        {
            var r = (d + Math.random()*16)%16 | 0;
            d = Math.floor(d/16);
            return (c=='x' ? r : (r&0x3|0x8)).toString(16);
        });
        keyField.value=uuid;
        keyField1.value=uuid;
    }
</script>
<%@include file="footer.jsp" %>
</body>
</html>
