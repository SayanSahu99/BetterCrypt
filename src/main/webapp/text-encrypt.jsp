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
    <form method="post" class="needs-validation" novalidate>
        <div class="form-floating mb-3" >
            <textarea class="form-control" placeholder="Enter Input Text here" id="floatingTextarea" style="height: 100px" required></textarea>
            <label for="floatingTextarea">Input Text</label>
        </div>
    <div class="form-floating">
        <input type="password" class="form-control" id="floatingKey" placeholder="123456" required>
        <label for="floatingKey">Secret Key</label>
    </div>
    <button type="submit" class="btn btn-primary mt-4" >Submit</button>
    </form>
    </div>
</div>
<div class="card mx-5 my-5" >
    <div class="card-body">
        <h5 class="card-title">Encrypted Text</h5>
        <form method="get">
            <textarea class="form-control" placeholder="Output Text" id="floatingTextarea1" disabled readonly style="height: 100px"></textarea>
        </form>
    </div>
</div>
<script>
'use strict'

// Fetch all the forms we want to apply custom Bootstrap validation styles to
var forms = document.querySelectorAll('.needs-validation')

// Loop over them and prevent submission
Array.prototype.slice.call(forms)
.forEach(function (form) {
form.addEventListener('submit', function (event) {
if (!form.checkValidity()) {
event.preventDefault()
event.stopPropagation()
}
form.classList.add('was-validated')
}, false)
})
</script>
</body>
</html>
