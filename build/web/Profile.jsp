<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Profile Card</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="css/Profile.css">
    </head>

    <body>

        <div class="card-container">

            <div class="upper-container">
                <div class="image-container">
                    <img src="profile.jpg" />
                </div>
            </div>

            <div class="lower-container">
                <div>
                    <h3>${sessionScope.acc.user}</h3>
                    <c:if test="${sessionScope.acc.isAdmin == 1}"> 
                        <h4>Admin</h4>
                    </c:if>
                    <c:if test="${sessionScope.acc.isSell == 1}"> 
                        <h4>Seller</h4>
                    </c:if>
                    <c:if test="${sessionScope.acc.isSell == 0 && sessionScope.acc.isAdmin == 0}"> 
                        <h4>User</h4>
                    </c:if>
                </div>
                <div>
                    <p>Sneakerhead16887475597183</p>
                </div>
                <div>
                    <a href="logout" class="btn">Log Out</a>
                </div>
            </div>

        </div>

    </body>
</html>