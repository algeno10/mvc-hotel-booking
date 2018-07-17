<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp" %>
    	
    <div class="container">

    <!-- ----------------------------------------------------------------- -->
    
      <div class="row">
      
        <!-- Column to display the personal details -->
        <div class="col-sm-6">
        
          <div class="panel panel-primary">
          
            <div class="panel-heading">
             <h4 align="center">Personal Details</h4>
            </div>
            
            <div class="panel-body">
              <!-- Code to display the personal details -->
              <div class="text-center">
                <h3>Name: <strong>${registerModel.user.firstName} ${registerModel.user.lastName}</strong></h3>
                <h4>Email: <strong>${registerModel.user.email}</strong></h4>
                <h4>Contact Number: <strong>${registerModel.user.contactNumber}</strong></h4>
                <h4>Role: <strong>${registerModel.user.role}</strong></h4>
                <p>
                   <!-- anchor to move to the edit of personal details -->
                   <a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-primary">Edit</a>
                
                </p>
              
              </div>
              
            </div>

          </div>
        </div>
      </div>
      
      <!-- ----------------------------------------------------------------- -->
      
      <!-- column to display the address -->
      <div class="col-sm-6">
      
        <div class="panel panel-primary">
        
          <div class="panel-heading">
            <h4 align="center">Address</h4>
          </div>
          
          <div class="panel-body">
          
            <div class="text-center">
            	<!-- code to display the communication address -->
            	<p>${registerModel.billing.addressLineOne},</p>
            	<p>${registerModel.billing.addressLineTwo},</p>
            	<p>${registerModel.billing.city} - ${registerModel.billing.postalCode},</p>
				<p>${registerModel.billing.state}</p>
				<p>${registerModel.billing.country}</p>
				<p>
				  <!-- anchor to move to the edit of the address-->
                  <a href="${flowExecutionUrl}&_eventId_billing" class="btn btn-primary">Edit</a>
				</p>
             </div>
          </div>
          
          
        </div>
      
      </div>
      
      <!-- ----------------------------------------------------------------- -->
      
      <!-- to provide the confirm button after displaying the result -->
      <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
          <div class="text-center">
          
            <!-- acchor to move to the success page -->
            <a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary">Confirm</a>
          
          </div>
        
        </div>
      </div>
    	
      <!-- ----------------------------------------------------------------- -->	
    	
    </div>
    	
<%@include file="../shared/flows-footer.jsp" %>