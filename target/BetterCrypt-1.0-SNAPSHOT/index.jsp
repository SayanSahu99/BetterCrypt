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
    <link href="https://fonts.googleapis.com/css2?family=Great+Vibes&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
</head>
<body>
<%@include file="header.jsp" %>
<header class="masthead text-white text-center">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
<%--            <div class="col-xl-9 mx-auto"><h1 class="mb-5">Build a landing page for your business or project and generate more leads!</h1></div>--%>
            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">
<%--                <form>--%>
<%--                    <div class="form-row">--%>
<%--                        <div class="col-12 col-md-9 mb-2 mb-md-0"><input class="form-control form-control-lg" type="email" placeholder="Enter your email..." /></div>--%>
<%--                        <div class="col-12 col-md-3"><button class="btn btn-block btn-lg btn-primary" type="submit">Sign up!</button></div>--%>
<%--                    </div>--%>
<%--                </form>--%>
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
        <h2 class="mb-5">What people are saying...</h2>
        <div class="row">
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="assets/img/testimonials-1.jpg" alt="..." />
                    <h5>Margaret E.</h5>
                    <p class="font-weight-light mb-0">"This is fantastic! Thanks so much guys!"</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="assets/img/testimonials-2.jpg" alt="..." />
                    <h5>Fred S.</h5>
                    <p class="font-weight-light mb-0">"Bootstrap is amazing. I've been using it to create lots of super nice landing pages."</p>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="testimonial-item mx-auto mb-5 mb-lg-0">
                    <img class="img-fluid rounded-circle mb-3" src="assets/img/testimonials-3.jpg" alt="..." />
                    <h5>Sarah W.</h5>
                    <p class="font-weight-light mb-0">"Thanks so much for making these free resources available to us!"</p>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Call to Action-->
<section class="call-to-action text-white text-center">
<%--    <div class="overlay"></div>--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col-xl-9 mx-auto"><h2 class="mb-4">Ready to get started? Sign up now!</h2></div>--%>
<%--            <div class="col-md-10 col-lg-8 col-xl-7 mx-auto">--%>
<%--                <form>--%>
<%--                    <div class="form-row">--%>
<%--                        <div class="col-12 col-md-9 mb-2 mb-md-0"><input class="form-control form-control-lg" type="email" placeholder="Enter your email..." /></div>--%>
<%--                        <div class="col-12 col-md-3"><button class="btn btn-block btn-lg btn-primary" type="submit">Sign up!</button></div>--%>
<%--                    </div>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
</section>
<!-- Footer-->
<footer class="footer bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
                <ul class="list-inline mb-2">
                    <li class="list-inline-item"><a href="assets/SRS%20Document%20on%20Data%20Encryption%20System%20(AES%20with%20Complement).pdf">About</a></li>
                    <li class="list-inline-item"></li>
                    <li class="list-inline-item"><a href="#!">Contact</a></li>
                    <li class="list-inline-item"></li>
                    <li class="list-inline-item"><a href="#!">Terms of Use</a></li>
                    <li class="list-inline-item"></li>
                    <li class="list-inline-item"><a href="#!">Privacy Policy</a></li>
                </ul>
                <p class="text-muted small mb-4 mb-lg-0">BetterCrypt© 2021. All Rights Reserved.</p>
            </div>
            <div class="col-lg-6 h-100 text-center text-lg-right my-auto">
                <ul class="list-inline mb-0">
                    <li class="list-inline-item mr-3">
                        <a href="https://www.facebook.com/shubhankar.haldia.1"><i class="fab fa-facebook fa-2x fa-fw"></i></a>
                    </li>
                    <li class="list-inline-item mr-3">
                        <a href="https://twitter.com/Shubhan71506563"><i class="fab fa-twitter-square fa-2x fa-fw"></i></a>
                    </li>
                    <li class="list-inline-item">
                        <a href="https://www.instagram.com/shubhankarhaldia/"><i class="fab fa-instagram fa-2x fa-fw"></i></a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>