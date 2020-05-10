package iducs.java.lombok;

import iducs.java.lombok.LombokModel.LombokModelBuilder;

public class LombokTest {
	 public static void main(String[] args) {
		 
		 LombokModel lombokModel = new LombokModelBuilder()
                 .groupid("org.projectlombok")
                 .artifactid("lombok")
                 .version("1.18.12")
                 .build();
		 
		 //Lombok 사용
		 System.out.println("lombok library 사용함");
		 System.out.println("lombokModel : " + lombokModel);
		 System.out.println("lombokModel : " + lombokModel.toString());
		 System.out.println("lombokModel : " + lombokModel.hashCode());
		 System.out.println("");
		 
		 LombokModel lombokModel1 = new LombokModelBuilder()
                 .groupid("org.projectlombok")
                 .artifactid("lombok")
                 .version("1.18.12")
                 .build();
		 System.out.println("lombokModel1 : " + lombokModel.hashCode());
		 System.out.println("");
		 
		 
		 NonLombokModel nonLombokModel = new NonLombokModel("mapstruct-processor","org.mapstruct","1.3.1");
		 //Java Bean 사용 
		 System.out.println("lombok library 사용안함!");
		 System.out.println("nonLombokModel : " + nonLombokModel);
		 System.out.println("nonLombokModel : " + nonLombokModel.toString());
		 System.out.println("nonLombokModel : " + nonLombokModel.hashCode());
		 
		 NonLombokModel nonLombokModel1 = new NonLombokModel("mapstruct-processor","org.mapstruct","1.3.1");
		 System.out.println("nonLombokModel : " + nonLombokModel1.hashCode());
	}
}
