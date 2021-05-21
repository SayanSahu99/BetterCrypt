<%--
  Created by IntelliJ IDEA.
  User: Sharath
  Date: 26-04-2021
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset = "UTF-8">
    <title>Image encryption</title>
    <link rel="icon" type="image/x-icon" href="assets/BetterCryptLogo.ico" />
</head>
<body>
<%@include file="header.jsp" %>
<%
    Object error = request.getAttribute("error");
    if(error != null) {
        out.println("<div class=\"alert alert-danger\" role=\"alert\">");
        out.println(error);
        out.println("</div>");
    }
    error = null;
%>

<!-- Modal -->
<div class="modal fade" id="emailModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="staticBackdropLabel">Enter Email</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="sendEmailForm">
                    <div class="mb-3">
                        <label for="emailText" class="form-label">Email address</label>
                        <input id="emailText" name="email" type="email" class="form-control" aria-describedby="emailHelp">
                        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
                    </div>
                    <button type="button" onclick="return callServlet();" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="card mx-5 my-5" >
    <div class="card-body">
        <h5 class="card-title">Image Encryption</h5>
        <form id="imageEncryptForm" name="image-encrypt-form" method="post" class="needs-validation" onsubmit="return validateForm()" enctype="multipart/form-data" action="${pageContext.request.contextPath}/ImageEncryptServlet" novalidate>
            <div class="input-group mb-3">
                <input name="file" type="file" class="form-control" id="inputGroupFile02" accept="image/*" onchange="loadFile(event)" required>
            </div>
            <img id="image" width="200" class="rounded mx-auto mb-3 d-block" alt="">
            <div class="input-group mb-3">
                <select name="bits" class="form-select" aria-label="Default select example">
                    <option value="128">128 Bits</option>
                    <option value="192">192 Bits</option>
                    <option value="256">256 Bits</option>
                </select>
            </div>
            <div class="form-floating mb-3">
                <input name="floatingKey" type="password" class="form-control" id="floatingKey" placeholder="123456">
                <label for="floatingKey">Secret Key</label>
            </div>
            <button type="submit" class="btn btn-primary mt-4" >Download</button>
            <button id="SendButton" type="button" class="btn btn-primary mt-4" onclick="return showModal();" data-bs-target="#emailModal">Send</button>
        </form>
    </div>
</div>
<div class="card mx-5 my-5" >
    <div class="card-body">
        <h5 class="card-title">Generate Random Key</h5>
        <form >
            <input class="form-control" placeholder="Output Text" id="floatingTextarea2" disabled readonly >
            <button type="button" class="btn btn-primary mt-4" onclick="generateUUID()" >Generate Key</button>
        </form>
    </div>
</div>
<script>
    'use strict'

    var forms = document.querySelectorAll('.needs-validation')

    function showModal() {
        //onclick="return callServlet();"

        if(!validateForm()) {
            return false;
        }
        var myModal = new bootstrap.Modal(document.getElementById('emailModal'), {
            keyboard: false
        })

        console.log(document.forms);

        var modalToggle = document.getElementById('emailModal') // relatedTarget
        myModal.show(modalToggle)
        //document.forms[0].action = "${pageContext.request.contextPath}/ImageEncryptServlet";
        //document.forms[0].submit();
    }

    function validateEmail(email) {
        const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(String(email).toLowerCase());
    }

    function callServlet() {
        var email = document.getElementById("emailText");
        if(!validateEmail(email.value)) {
            if(email.classList.contains("is-valid")){
                email.classList.remove("is-valid");
            }
            email.classList.add("is-invalid");
            return false;
        }
        console.log(email.value);
        var d = new Date();
        d.setTime(d.getTime() + (24*60*60*1000));
        var expires = "expires="+ d.toUTCString();
        document.cookie = "email" + "=" + email.value + ";" + expires + ";path=/";
        document.forms[1].action = "${pageContext.request.contextPath}/EmailServlet";
        document.forms[1].submit();
    }

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

    var loadFile = function(event) {
        var image = document.getElementById('image');
        image.src = URL.createObjectURL(event.target.files[0]);
    };

    function generateUUID()
    {
        var d = new Date().getTime();
        var keyField = document.getElementById("floatingTextarea2");
        var keyField1= document.getElementById("floatingKey");
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
