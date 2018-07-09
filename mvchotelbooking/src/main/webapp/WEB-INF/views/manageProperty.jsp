<div class="container">


	<div class="row">
	
		<div class="col-md-offset-2 col-md-8">
		
			<div class="panel panel-primary">
			
				<div class="panel-heading">
				
					<h4>Property Management</h4>
				
				</div>
				
				<div class="panel-body">
				
					<!-- FORM ELEMENTS -->
					<form class="form-horizontal">
					
					    <!-- Property Name -->
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Property Name: </label>
							<div class="col-md-8">
								<input type="text" name="name" id="name" placeholder="Property Name" class="form-control"/>
								<em class="help-block">Please enter Property Name!</em>
							</div>
						</div>
						
						<!-- Property Address -->
						<div class="form-group">
							<label class="control-label col-md-4" for="address">Enter Property Address: </label>
							<div class="col-md-8">
								<input type="text" name="address" id="address" placeholder="Property Address" class="form-control"/>
								<em class="help-block">Please enter Property Address!</em>
							</div>
						</div>
						
						<!-- Property Description -->
						<div class="form-group">						
							<label class="control-label col-md-4" for="description">Property Description: </label>
							<div class="col-md-8">
								<textarea name="description" id="description" rows="4" placeholder="Write a description">
								</textarea>
							</div>
						</div>
						
						<!-- Booking Price -->
						<div class="form-group">
							<label class="control-label col-md-4" for="bookingPrice">Enter Booking Price: </label>
							<div class="col-md-8">
								<input type="number" name="bookingPrice" id="bookingPrice" placeholder="Booking Price in R" class="form-control"/>
							</div>
						</div>
						
						<!-- Quantity available -->
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity Available: </label>
							<div class="col-md-8">
								<input type="number" name="quantity" id="quantity" placeholder="Quantity Available" class="form-control"/>
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
								
							</div>
						
						</div>
				
				
					</form>
				
				</div>
			
			</div>
		</div>	
	</div>
</div>