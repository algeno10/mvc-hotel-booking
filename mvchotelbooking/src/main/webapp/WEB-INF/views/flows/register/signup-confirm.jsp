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
            </div>
            
            <div class="panel-footer">
              <!-- anchor to move to the edit of personal details -->
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
            <!-- code to display the communication address -->
          </div>
          
          <div class="panel-footer">
            <!-- anchor to move to the edit of the address-->
          </div>
          
        </div>
      
      </div>
      
      <!-- ----------------------------------------------------------------- -->
      
      <!-- to provide the confirm button after displaying the result -->
      <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
          <div class="text-center">
          
            <!-- acchor to move to the success page -->
            <a href="${flowExecutionUrl}&_eventId_success" class="btn btn-primary">Confirm</a>
          
          </div>
        
        </div>
      </div>
    	
      <!-- ----------------------------------------------------------------- -->	
    	
    </div>
    	
<%@include file="../shared/flows-footer.jsp" %>