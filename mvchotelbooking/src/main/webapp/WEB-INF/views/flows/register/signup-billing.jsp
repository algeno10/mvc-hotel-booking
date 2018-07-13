<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp" %>
    	
<div class="container">
    	
   <div class="row">
   
     <div class="col-md-6 col-md-offset-3">
     
       <div class="panel panel-primary">
       
         <div class="panel-heading">
           <h4 align="center">Sign Up - Address</h4>
         </div>
         
         <div class="panel-body">
         
           <sf:form
            method="POST"
            class="form-horizontal"
            id="billingForm"
            modelAttribute="billing"
            >
           
              <!-- Address Line One -->
   			  <div class="form-group">
   				<label class="control-label col-md-4" for="addressLineOne">Address Line One:</label>
   				<div class="col-md-8">
   					<sf:input type="text" path="addressLineOne" class="form-control"
   					placeholder="Enter Address Line One"/>
   				</div>
   			 </div>
   			 
   			 <!-- Address Line Two -->
   			 <div class="form-group">
   				<label class="control-label col-md-4" for="addressLineTwo">Address Line Two:</label>
   				<div class="col-md-8">
   					<sf:input type="text" path="addressLineTwo" class="form-control"
   					placeholder="Enter Address Line Two"/>
   				</div>
   			 </div>
           
             <!-- City -->
   			 <div class="form-group">
   				<label class="control-label col-md-4" for="city">City:</label>
   				<div class="col-md-8">
   					<sf:input type="text" path="city" class="form-control"
   					placeholder="Enter City Name"/>
   				</div>
   			 </div>
   			 
   			 <!-- State -->
   			 <div class="form-group">
   				<label class="control-label col-md-4" for="state">State:</label>
   				<div class="col-md-8">
   					<sf:input type="text" path="state" class="form-control"
   					placeholder="Enter City Name"/>
   				</div>
   			 </div>
   			 
   			 <!-- Postal Code -->
   			 <div class="form-group">
   				<label class="control-label col-md-4" for="postalCode">Postal Code:</label>
   				<div class="col-md-8">
   					<sf:input type="text" path="postalCode" class="form-control"
   					placeholder="XXXX"/>
   				</div>
   			 </div>
   			 
   			 <!-- Country -->
   			 <div class="form-group">
   				<label class="control-label col-md-4" for="country">Country:</label>
   				<div class="col-md-8">
   					<sf:input type="text" path="country" class="form-control"
   					placeholder="XXXX"/>
   				</div>
   			 </div>
   			 
   			 <div class="form-group">
   				<div class="col-md-8">
   					<!-- Submit button for moving to the personal -->
   					<button type="submit" class="btn btn-primary btn-george"
   					   name="_eventId_personal">
   						<span class="glyphicon glyphicon-chevron-left"></span> Previous - Personal 
   					</button>
   					
   					
   					<!-- Submit button for moving to the confirm -->
   					<button type="submit" class="btn btn-primary btn-george"
   					   name="_eventId_confirm">
   						Next - Confirm <span class="glyphicon glyphicon-chevron-left"></span> 
   					</button>
   				</div>
   			 </div>
           
           </sf:form>
         
         </div>
       
       </div>
     
     </div>
   
   </div>  	
    	
</div>
    	
<%@include file="../shared/flows-footer.jsp" %>