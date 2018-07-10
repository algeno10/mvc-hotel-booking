<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">


	<div class="row">
	
		<div class="col-md-offset-2 col-md-8">
		
			<div class="panel panel-primary">
			
				<div class="panel-heading">
				
					<h4>Property Management</h4>
				
				</div>
				
				<div class="panel-body">
				
					<!-- FORM ELEMENTS -->
					<sf:form class="form-horizontal" modelAttribute="property">
					
					    <!-- Property Name -->
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Property Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Property Name" class="form-control"/>
								<em class="help-block">Please enter Property Name!</em>
							</div>
						</div>
						
						<!-- Property Address -->
						<div class="form-group">
							<label class="control-label col-md-4" for="address">Enter Property Address: </label>
							<div class="col-md-8">
								<sf:input type="text" path="address" id="address" placeholder="Property Address" class="form-control"/>
								<em class="help-block">Please enter Property Address!</em>
							</div>
						</div>
						
						<!-- Property Description -->
						<div class="form-group">						
							<label class="control-label col-md-4" for="description">Property Description: </label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" rows="4" placeholder="Write a description"/>
							</div>
						</div>
						
						<!-- Booking Price -->
						<div class="form-group">
							<label class="control-label col-md-4" for="bookingPrice">Enter Booking Price: </label>
							<div class="col-md-8">
								<sf:input type="number" path="bookingPrice" id="bookingPrice" placeholder="Booking Price in R" class="form-control"/>
							</div>
						</div>
						
						<!-- Quantity available -->
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity Available: </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity Available" class="form-control"/>
							</div>
						</div>
						
						<!-- Property Category -->
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select Category: </label>
							<div class="col-md-8">
								<select name="categoryId" id="categoryId" class="form-control">
									<option value="1">Category One</option>
									<option value="2">Category Two</option>
									<option value="3">Category Three</option>
								</select>
							</div>
						</div>
						
						
						<div class="form-group">
						
							<div class="col-md-offset-4 col-md-8">
							
								<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
								
								<!-- Hidden fields for property -->
								<sf:hidden path="id"/>
								<sf:hidden path="code"/>
								<sf:hidden path="active"/>
								<sf:hidden path="categoryId"/>
								<sf:hidden path="clientId"/>
								<sf:hidden path="bookings"/>
								<sf:hidden path="views"/>
								
							</div>
						
						</div>
				
				
					</sf:form>
				
				</div>
			
			</div>
		</div>	
	</div>
</div>