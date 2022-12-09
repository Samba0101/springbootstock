
  package com.projet.pStock.sécurité;
  
  public interface SecurityParams {
  
  public static final String JWT_HEADER_NAME="Authorization"; 
  public static final String SECRET="sam@elfecky.net";
  public static final long EXPIRATION=10*24*3600;
  public static final String HEADER_PREFIXE="Bearer "; 
  }
 