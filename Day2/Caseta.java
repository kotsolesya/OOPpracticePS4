package veadtable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Caseta {

	  private int id; 
	  private String name;
	  private boolean nayava;
	  private double cost;
	  private double zastava;

	  public int getId() {
	   return id;}

	  public void setId(int id) {
	   this.id = id;}
	  
	  public String getName() {
	   return name;}

	  public void setName(String ima) {
	   this.name = ima;}

	  public boolean getNayava() {
	   return nayava;}

	  public void setNayava(boolean nayavnist) {
	   this.nayava = nayavnist;}

	  public double getCost() {
	   return cost;}

	  public void setCost(double costs) {
	   this.cost = costs;}
	 
	  public double getZastava() {
	   return zastava;}

	  public void setZastava(double zalog) {
	   this.zastava = zalog;}

	   	  public boolean equals(Object other){

	   if (!(other instanceof Caseta)) return false;

	   Caseta castOther=(Caseta)other;

	   return new EqualsBuilder().append(this.getName(),castOther.getName()).isEquals();}
	   
	   public int hashCode(){

	   return new HashCodeBuilder().append(getName()).toHashCode();}

} 

	

