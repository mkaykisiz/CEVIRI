package com.kaykisiz.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(University.class)
public abstract class University_ {

	public static volatile ListAttribute<University, Uye> uyeler;
	public static volatile SingularAttribute<University, Short> adres_ID;
	public static volatile SingularAttribute<University, String> university_Name;

}

