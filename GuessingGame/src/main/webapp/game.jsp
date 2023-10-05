<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">

    <title>Guessor Game</title>
</head>
<body>
    <div class="container">
        <jsp:include page="navbar.jsp" /> <!-- Include the navbar.jsp content here -->
        <br>
        <div class="card py-5">
            <img alt="" class="img-fluid mx-auto" style="max-width: 400px" src="C:/Users/LENOVO/Desktop/Resume Builder/GuessingGamePic.jpg">
            <h1 class='text-primary text-uppercase text-center'>Welcome to Guessor Game</h1>
            <div class='container text-center'>
                <form action="GuessServlet" method="post"> <!-- Post the form data to the GuessServlet -->
                    <label for="userGuess">Enter your guess: </label>
                    <input type="number" id="userGuess" name="userGuess" required>
                    <button class="btn btn-outline-primary text-center" type="submit">Submit Guess</button>
                </form>
                <div>
                    <!-- Display the result message here -->
                    <jsp:include page="result.jsp" />
                </div>
            </div>
        </div>
    </div>
</body>
</html>
