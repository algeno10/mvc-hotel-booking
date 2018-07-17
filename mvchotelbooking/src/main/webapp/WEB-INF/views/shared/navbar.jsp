    <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${contextRoot}/home">Online Booking</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li id="about">
                        <a href="${contextRoot}/about">About</a>
                    </li>
                    
                    <li id="contact">
                        <a href="${contextRoot}/contact">Contact</a>
                    </li>
                    
                    <li id="listProperty">
                        <a href="${contextRoot}/show/all/property">View Properties</a>
                    </li>
                    
                    <li id="manageProperty">
                        <a href="${contextRoot}/manage/property">Manage Properties</a>
                    </li>
                </ul>
                
                <ul class="nav navbar-nav navbar-right">
                	<li id="register">
                        <a href="${contextRoot}/register">Sign Up</a>
                    </li>
                    <li id="login">
                        <a href="${contextRoot}/login">Log-In</a>
                    </li>
                    <li class="dropdown">
                        <a href="javascript:void(0)"
                           class="btn btn-default dropdown-toggle"
                           id="dropdownMenu1"
                           data-toggle="dropdown">
                           Full Name
                           <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu" >
                        	<li>
                        		<a href="${contextRoot}/booking">
                        		    <span class="glyphicon glyphicon-plus"></span>
                        		    <span class="badge">0</span>
                        		     - R 0.0
                        		</a>
                        	</li>
                        	<li class="divider" role="separator"></li>
                        	
                        	<li>
                        		<a href="${contextRoot}/logout">Logout</a>
                        	</li>
                        </ul>
                    </li>
                </ul>
                
                
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>