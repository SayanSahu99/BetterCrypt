<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 26-04-2021
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>BetterCrypt</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/BetterCryptLogo1.ico" />
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.15.3/js/all.js" crossorigin="anonymous"></script>
    <!-- Simple line icons-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css" rel="stylesheet" type="text/css" />
    <!-- Google fonts-->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/css/toastr.min.css" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />

    <style>
        body {
            padding-top: 50px !important;
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>
<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
            </div>
        </div>
    </div>
</header>
<!-- Icons Grid-->
<section class="features-icons bg-light text-center">
    <div class="container">
        <div class="row">
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                    <div class="features-icons-icon d-flex"><i class="icon-screen-desktop m-auto text-primary"></i></div>
                    <h3>Portable</h3>
                    <p class="lead mb-0">This website will look great and run well on any OS!</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
                    <div class="features-icons-icon d-flex"><i class="icon-globe m-auto text-primary"></i></div>
                    <h3>Always Available</h3>
                    <p class="lead mb-0">The website will be up and running 24/7 for any user at any time</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="features-icons-item mx-auto mb-0 mb-lg-3">
                    <div class="features-icons-icon d-flex"><i class="icon-check m-auto text-primary"></i></div>
                    <h3>Easy to Use</h3>
                    <p class="lead mb-0">Anyone can easily understand and use this website</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Image Showcases-->
<section class="showcase">
    <div class="container-fluid p-0">
        <div class="row no-gutters">
            <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('assets/img/bg-showcase-1.jpeg')"></div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                <h2>Advanced Encryption</h2>
                <p class="lead mb-0">Using both AES encryption and Complement method BetterCrypt provides a high level of security to your data</p>
            </div>
        </div>
        <div class="row no-gutters">
            <div class="col-lg-6 text-white showcase-img" style="background-image: url('assets/img/secured.jpg')"></div>
            <div class="col-lg-6 my-auto showcase-text">
                <h2>Fully Secured</h2>
                <p class="lead mb-0">BetterCrypt doesn't store any of your precious data. All data is immediately deleted after encryption is complete</p>
            </div>
        </div>
        <div class="row no-gutters">
            <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('assets/img/Ease-of-use.jpeg')"></div>
            <div class="col-lg-6 order-lg-1 my-auto showcase-text">
                <h2>Easy to Use</h2>
                <p class="lead mb-0">Just add your text or images and your data will be securely encrypted through the click of a button</p>
            </div>
        </div>
    </div>
</section>
<!-- Testimonials-->
<section class="testimonials text-center bg-light">
    <div class="container">
        <h2 class="mb-5">OUR AMAZING TEAM</h2>
        <div class="row">
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="https://avataaars.io/?avatarStyle=Transparent&topType=ShortHairShortRound&accessoriesType=Blank&hairColor=Black&facialHairType=Blank&clotheType=Hoodie&clotheColor=PastelGreen&eyeType=Default&eyebrowType=RaisedExcited&mouthType=Smile&skinColor=Brown" alt="..." />
                    <h5>Sharath Pai</h5>
                    <p class="font-weight-light mb-0">"Prevent unauthorized access to your private data. Share your private data or information with care. Ensure your safety now by using our free service."</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="https://avataaars.io/?avatarStyle=Transparent&topType=ShortHairShortFlat&accessoriesType=Sunglasses&hairColor=Black&facialHairType=Blank&clotheType=ShirtCrewNeck&clotheColor=Black&eyeType=Surprised&eyebrowType=FlatNatural&mouthType=Smile&skinColor=Brown" alt="..." />
                    <h5>Shubhankar Haldia</h5>
                    <p class="font-weight-light mb-0">"Is someone watching you? Why feel scared when you can protect your data using BetterCrypt. BetterCrypt is my dream towards a digital world where you and your family are empowered with the knowledge of data protection and privacy."</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="https://avataaars.io/?avatarStyle=Transparent&topType=ShortHairShortFlat&accessoriesType=Wayfarers&hairColor=Black&facialHairType=Blank&facialHairColor=Red&clotheType=BlazerSweater&eyeType=Side&eyebrowType=RaisedExcitedNatural&mouthType=Twinkle&skinColor=Tanned" alt="..." />
                    <h5>Sayan Sahu</h5>
                    <p class="font-weight-light mb-0">"In this digital age security and risk management of sensitive data should be the top most priority of businesses. Use our free resources to ensure the safety of your data."</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Call to Action-->
<section class="call-to-action text-white text-center">
</section>
<!-- Footer-->
<%@include file="footer.jsp" %>
<!-- Bootstrap core JS-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" ></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/js/toastr.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>