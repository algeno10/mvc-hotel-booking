<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		
		
		<c:if test="${not empty message}">
			<div class="col-xs-12">
				<div class="alert alert-success alert-dismissible">
				
					<button type="button" class="close" data-dismiss="alert">&times;</button>
					
					${message}
					
				</div>
			</div>
		</c:if>
		
		<div class="col-md-offset-2 col-md-8">
		
			<div class="panel panel-primary">
			
				<div class="panel-heading">
				
					<h4>Property Management</h4>
				
				</div>
				
				<div class="panel-body">
				
					<!-- FORM ELEMENTS -->
					<sf:form class="form-horizontal" modelAttribute="property"
						action="${contextRoot}/manage/property"
						method="POST"
						enctype="multipart/form-data"
					>
					
					    <!-- Property Name -->
						<div class="form-group">
							<label class="control-label col-md-4" for="name">Enter Property Name: </label>
							<div class="col-md-8">
								<sf:input type="text" path="name" id="name" placeholder="Property Name" class="form-control"/>
								<sf:errors path="name" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<!-- Property Address -->
						<div class="form-group">
							<label class="control-label col-md-4" for="address">Enter Property Address: </label>
							<div class="col-md-8">
								<sf:input type="text" path="address" id="address" placeholder="Property Address" class="form-control"/>
								<sf:errors path="address" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<!-- Property Description -->
						<div class="form-group">						
							<label class="control-label col-md-4" for="description">Property Description: </label>
							<div class="col-md-8">
								<sf:textarea path="description" id="description" class="form-control" placeholder="Write a description"/>
								<sf:errors path="description" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<!-- Booking Price -->
						<div class="form-group">
							<label class="control-label col-md-4" for="bookingPrice">Enter Booking Price: </label>
							<div class="col-md-8">
								<sf:input type="number" path="bookingPrice" id="bookingPrice" placeholder="Booking Price in R" class="form-control"/>
								<sf:errors path="bookingPrice" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<!-- Quantity available -->
						<div class="form-group">
							<label class="control-label col-md-4" for="quantity">Quantity Available: </label>
							<div class="col-md-8">
								<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity Available" class="form-control"/>
							</div>
						</div>
						
						<!-- File element for image upload -->
						<div class="form-group">
							<label class="control-label col-md-4" for="file">Select an Image: </label>
							<div class="col-md-8">
								<sf:input type="file" path="file" id="file" class="form-control"/>
								<sf:errors path="file" cssClass="help-block" element="em"/>
							</div>
						</div>
						
						<!-- Property Category -->
						<div class="form-group">
							<label class="control-label col-md-4" for="categoryId">Select Category: </label>
							<div class="col-md-8">
								<sf:select path="categoryId" id="categoryId" class="form-control"
									items="${categories}"
									itemLabel="name"
									itemValue="id"/>
									
									<!-- Category Button -->
								<c:if test="${property.id == 0}">
									<div class="text-right">
										<br/>
										<button type="button" data-toggle="modal" data-target="#myCategoryModal" class="btn btn-warning btn-xs">Add Category</button>
									</div>
								</c:if>
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
	
	
	<!-- Category Dialog Box -->
	<!-- Modal -->
	<div class="modal fade" id="myCategoryModal" role="dialog" tabindex="-1" aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				
				<!-- Modal Header -->
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Add New Category</h4>
				</div>
				
				<div class="modal-body">
				
					<!-- Category Form -->
					<sf:form id="categoryForm" modelAttribute="category" action="${contextRoot}/manage/category"
						method="POST" class="form-horizontal">
						
						<!-- Category Name -->
						<div class="form-group">
							<label for="category_name" class="control-label col-md-4">Category Name:</label>
							<div class="col-md-8 validate">
								<sf:input type="text" path="name" id="category_name" class="form-control" placeholder="Category Name"/>
							</div>
						</div>
						
						<!-- Category Description -->
						<div class="form-group">
							<label for="description" class="control-label col-md-4">Category Description:</label>
							<div class="col-md-8 validate">
								<sf:textarea path="description" id="description" class="form-control" placeholder="Enter category description here!"/>
							</div>
						</div>
						
						<!-- Submit button -->
						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<input type="submit" value="Add Category" class="btn btn-primary"/>
							</div>
						</div>
						
					</sf:form>	
				</div>
			
			</div>
		</div>
	</div>
<!-- Category Dialog Box -->
	
	<div class="row">
		
		<div class="col-xs-12">
			<h3>Available Property</h3>
			<hr/>
		</div>
		
		<div class="col-xs-12">
			<div style="overflow:auto">
			
				<!-- Property table for Admin -->
				<table id="propertyTable" class="table table-striped
				table-bordered">

				<thead>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Address</th>
						<th>Quantity</th>
						<th>Booking Price</th>
						<th>Active</th>
						<th>Edit</th>
					</tr>
				</thead>
				
				
				<tfoot>
					<tr>
						<th>Id</th>
						<th>&#160;</th>
						<th>Name</th>
						<th>Address</th>
						<th>Quantity</th>
						<th>Booking Price</th>
						<th>Active</th>
						<th>Edit</th>
					</tr>
				</tfoot>
			</table>
				
			</div>
		</div>
		
	</div>
	

</div>