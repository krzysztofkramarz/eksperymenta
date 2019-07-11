package com.fonowizja.eksperymenta.hierarchy;

import lombok.Getter;
import lombok.Setter;

/**
 * @author krzysztof.kramarz
 */
@Getter
@Setter
class A
{
   String name = "A";

   public void print(){
      System.out.println("Jestem z A i mam: " + this.name);
   }
}
