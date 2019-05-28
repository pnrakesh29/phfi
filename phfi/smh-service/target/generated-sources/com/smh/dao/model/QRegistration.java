package com.smh.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QRegistration is a Querydsl query type for Registration
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QRegistration extends EntityPathBase<Registration> {

    private static final long serialVersionUID = -1519430521L;

    public static final QRegistration registration = new QRegistration("registration");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath anaemia = createString("anaemia");

    public final StringPath anmName = createString("anmName");

    public final StringPath anyotherproblem = createString("anyotherproblem");

    public final StringPath ashaFacilitatorName = createString("ashaFacilitatorName");

    public final StringPath ashaName = createString("ashaName");

    public final StringPath bleedexcessively = createString("bleedexcessively");

    public final StringPath bloodgroup = createString("bloodgroup");

    public final StringPath breathlessness = createString("breathlessness");

    public final NumberPath<Integer> caesarean = createNumber("caesarean", Integer.class);

    public final StringPath castcategory = createString("castcategory");

    public final StringPath caste = createString("caste");

    public final StringPath createdBy = createString("createdBy");

    public final StringPath createdDate = createString("createdDate");

    public final StringPath currentPlace = createString("currentPlace");

    public final StringPath dateOfRecentDelivery = createString("dateOfRecentDelivery");

    public final StringPath diabetes = createString("diabetes");

    public final StringPath districtMarital = createString("districtMarital");

    public final StringPath districtNatal = createString("districtNatal");

    public final NumberPath<Integer> earlyDelivery = createNumber("earlyDelivery", Integer.class);

    public final StringPath education = createString("education");

    public final StringPath educationOther = createString("educationOther");

    public final StringPath heartdisease = createString("heartdisease");

    public final NumberPath<Integer> height = createNumber("height", Integer.class);

    public final StringPath husbandFatherName = createString("husbandFatherName");

    public final StringPath husbandFirstName = createString("husbandFirstName");

    public final StringPath husbandSurname = createString("husbandSurname");

    public final StringPath hypertension = createString("hypertension");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath jaundice = createString("jaundice");

    public final StringPath landmarkMarital = createString("landmarkMarital");

    public final StringPath landmarkNatal = createString("landmarkNatal");

    public final StringPath lmp = createString("lmp");

    public final StringPath maternityStatus = createString("maternityStatus");

    public final NumberPath<Integer> noOfChildren = createNumber("noOfChildren", Integer.class);

    public final StringPath otherCurrentPlace = createString("otherCurrentPlace");

    public final StringPath otherReligion = createString("otherReligion");

    public final StringPath phc = createString("phc");

    public final StringPath phone1Marital = createString("phone1Marital");

    public final StringPath phone1Natal = createString("phone1Natal");

    public final StringPath phone2Marital = createString("phone2Marital");

    public final StringPath phone2Natal = createString("phone2Natal");

    public final NumberPath<Integer> pregnancyCount = createNumber("pregnancyCount", Integer.class);

    public final StringPath problemDesc = createString("problemDesc");

    public final StringPath regDate = createString("regDate");

    public final StringPath religion = createString("religion");

    public final StringPath severepallor = createString("severepallor");

    public final StringPath streetMarital = createString("streetMarital");

    public final StringPath streetNatal = createString("streetNatal");

    public final StringPath talukMarital = createString("talukMarital");

    public final StringPath talukNatal = createString("talukNatal");

    public final StringPath thyroidproblem = createString("thyroidproblem");

    public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final StringPath updatedDate = createString("updatedDate");

    public final StringPath villageMarital = createString("villageMarital");

    public final StringPath villageName = createString("villageName");

    public final StringPath villageNatal = createString("villageNatal");

    public final StringPath womenFirstName = createString("womenFirstName");

    public final StringPath womenHusbandName = createString("womenHusbandName");

    public final StringPath womenSurname = createString("womenSurname");

    public QRegistration(String variable) {
        super(Registration.class, forVariable(variable));
    }

    public QRegistration(Path<? extends Registration> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRegistration(PathMetadata<?> metadata) {
        super(Registration.class, metadata);
    }

}

