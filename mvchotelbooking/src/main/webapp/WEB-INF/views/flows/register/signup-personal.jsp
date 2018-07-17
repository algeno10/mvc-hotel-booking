<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp" %>
    	
  <div class="container">
    	
   	<div class="row">
   	
   		<div class="col-md-6 col-md-offset-3">
   		
   			<div class="panel panel-primary">
   			
   				<div class="panel-heading">
   					<h4 align="center">Sign Up - Personal</h4>
   				
   				<div class="panel-body">
   				
   					<sf:form
   					method="POST"
   					class="form-horizontal"
   					id="registerForm"
   					modelAttribute="user">
   						
   						<!-- First Name -->
   						<div class="form-group">
   							<label class="control-label col-md-4">First Name:</label>
   							<div class="col-md-8">
   								<sf:input type="text" path="firstName" class="form-control"
   								placeholder="First Name"/>
   								<sf:errors path="firstName" cssClass="help-block" element="em"/>
   							</div>
   						</div>
   						
   						<!-- Last Name -->
   						<div class="form-group">
   							<label class="control-label col-md-4">Last Name:</label>
   							<div class="col-md-8">
   								<sf:input type="text" path="lastName" class="form-control"
   								placeholder="Last Name"/>
   								<sf:errors path="lastName" cssClass="help-block" element="em"/>
   							</div>
   						</div>
   						
   						<!-- Email -->
   						<div class="form-group">
   							<label class="control-label col-md-4">Email:</label>
   							<div class="col-md-8">
   								<sf:input type="text" path="email" class="form-control"
   								placeholder="123@abc.com"/>
   								<sf:errors path="email" cssClass="help-block" element="em"/>
   							</div>
   						</div>
   						
   						<!-- Contact Number -->
   						<div class="form-group">
   							<label class="control-label col-md-4">Contact Number:</label>
   							<div class="col-md-8">
   								<sf:input type="text" path="contactNumber" class="form-control"
   								placeholder="012XXXXXXX"/>
   								<sf:errors path="contactNumber" cssClass="help-block" element="em"/>
   							</div>
   						</div>
   						
   						<!-- Password -->
   						<div class="form-group">
   							<label class="control-label col-md-4">Password:</label>
   							<div class="col-md-8">
   								<sf:input type="password" path="password" class="form-control"
   								placeholder="Password"/>
   								<sf:errors path="password" cssClass="help-block" element="em"/>
   							</div>
   						</div>
   						
   						<!-- Radio button using bootstrap class of radio-inline -->
   						<div class="form-group">
   							<label class="control-label col-md-4">Choose Role:</label>
   							<div class="col-md-8">
   								<label class="radio-inline">
   									<sf:radiobutton path="role" value="USER" checked="checked"/>User
   								</label>
   								<label class="radio-inline">
   									<sf:radiobutton path="role" value="CLIENT"/>Client
   								</label>
   							</div>
   						</div>
   						
   						<div class="form-group">
   							<div class="col-md-offset-4 col-md-8">
   								<!-- Submit button inside the form -->
   								<button type="submit" class="btn btn-primary btn-george"
   								  name="_eventId_billing">
   								  
   								  Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
   								  
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