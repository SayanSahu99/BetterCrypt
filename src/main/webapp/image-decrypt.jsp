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
<%
    Object error = request.getAttribute("error");
    if(error != null) {
        out.println("\n" +
                "\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <!-- Compiled and minified CSS -->\n" +
                "    <link href=\"//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css\" rel=\"stylesheet\" />\n" +
                "    <title></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<script src=\"//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js\" ></script>\n" +
                "<script src=\"//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js\"></script>\n" +
                "<script>toastr.error(\" "+error+"\", \"Error\");</script>\n" +
                "</body>\n" +
                "</html>\n");
    }

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
<div class="card mx-5 my-5" >
    <div class="card-body">
        <h5 class="card-title">Image Decryption</h5>
        <form name="image-decrypt-form" method="post" class="needs-validation" onsubmit="return validateForm()" enctype="multipart/form-data" action="${pageContext.request.contextPath}/ImageDecryptServlet" novalidate>
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
            <button type="submit" class="btn btn-primary mt-4" >Submit</button>
        </form>
    </div>
</div>
<script>
    'use strict'

    var forms = document.querySelectorAll('.needs-validation');

    var loadFile = function(event) {
        var image = document.getElementById('image');
        image.src = URL.createObjectURL(event.target.files[0]);
    };

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
<%@include file="footer.jsp" %>
</body>
</html>
