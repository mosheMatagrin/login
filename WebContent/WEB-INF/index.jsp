<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Client Form</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
<form method="post" action="clientForm" class="form-horizontal">
<!-- Form Name -->
<legend>Login Client</legend>

<div class="form-group">
  <label class="col-md-4 control-label" for="nom">Nom</label>  
  <div class="col-md-4">
  <input id="nom" name="nom" type="text" class="form-control input-md" value="<c:out value="${ client.nom }"/>" >
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="prenom">Prenom</label>  
  <div class="col-md-4">
  <input id="prenom" name="prenom" type="text" class="form-control input-md" value="<c:out value="${ client.prenom }"/>">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="birthDate">Date de naissance</label>  
  <div class="col-md-4">
  <input id="birthDate" name="birthDate" type="text" class="form-control input-md" value="<c:out value="${ client.birthDate }"/>">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="mail">Mail</label>  
  <div class="col-md-4">
  <input id="mail" name="mail" type="text" class="form-control input-md" value="<c:out value="${ client.mail }"/>">
  <span class="text-danger">${ error["mail"] }</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="mdp">Mot de passe</label>
  <div class="col-md-4">
    <input id="mdp" name="mdp" type="password" class="form-control input-md">
    <span class="text-danger">${ error["mdp"] }</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="repete_mdp">Repeter mot de passe</label>
  <div class="col-md-4">
    <input id="repete_mdp" name="repete_mdp" type="password" class="form-control input-md">
    <span class="text-danger">${ error["repete_mdp"] }</span>
  </div>
</div>

<div class="form-group">
  <div class="col-md-4 col-md-offset-4">
    <button class="btn btn-primary">Envoyer</button>
  </div>
</div>

</fieldset>
</form>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"   integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="   crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>
</html>