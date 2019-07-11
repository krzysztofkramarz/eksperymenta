package com.fonowizja.eksperymenta.hierarchy;

import lombok.Getter;
import lombok.Setter;

/**
 * @author krzysztof.kramarz
 */
@Getter
@Setter
class B extends  A
{

   String name = "B";

   public void print(){
      System.out.println("Jestem z B i mam: " + this.name);
   }
}
