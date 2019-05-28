package com.smh.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPregnancyVisit is a Querydsl query type for PregnancyVisit
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPregnancyVisit extends EntityPathBase<PregnancyVisit> {

    private static final long serialVersionUID = 837390956L;

    public static final QPregnancyVisit pregnancyVisit = new QPregnancyVisit("pregnancyVisit");

    public final StringPath babyMove = createString("babyMove");

    public final StringPath bp = createString("bp");

    public final StringPath bpDateFour = createString("bpDateFour");

    public final StringPath bpDateOne = createString("bpDateOne");

    public final StringPath bpDateSec = createString("bpDateSec");

    public final StringPath bpDateThird = createString("bpDateThird");

    public final StringPath createdBy = createString("createdBy");

    public final StringPath createdDate = createString("createdDate");

    public final StringPath feltGiddy = createString("feltGiddy");

    public final StringPath firstBp = createString("firstBp");

    public final StringPath firstHb = createString("firstHb");

    public final StringPath firstMalaria = createString("firstMalaria");

    public final StringPath firstRbs = createString("firstRbs");

    public final StringPath firstUltrasound = createString("firstUltrasound");

    public final StringPath firstUrine = createString("firstUrine");

    public final StringPath firstWeight = createString("firstWeight");

    public final StringPath fourBp = createString("fourBp");

    public final StringPath fourHb = createString("fourHb");

    public final StringPath fourthWeight = createString("fourthWeight");

    public final StringPath haveBlurredVision = createString("haveBlurredVision");

    public final StringPath haveCough = createString("haveCough");

    public final StringPath haveFever = createString("haveFever");

    public final StringPath haveHeadaches = createString("haveHeadaches");

    public final StringPath hb = createString("hb");

    public final StringPath hbDateFour = createString("hbDateFour");

    public final StringPath hbDateOne = createString("hbDateOne");

    public final StringPath hbDateSec = createString("hbDateSec");

    public final StringPath hbDateThird = createString("hbDateThird");

    public final StringPath howLongHaveCough = createString("howLongHaveCough");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath isAbdominalPain = createString("isAbdominalPain");

    public final StringPath isAnkleDepression = createString("isAnkleDepression");

    public final StringPath isBangles = createString("isBangles");

    public final StringPath isBleeding = createString("isBleeding");

    public final StringPath isBreathless = createString("isBreathless");

    public final StringPath isBurningPain = createString("isBurningPain");

    public final StringPath isConsciousness = createString("isConsciousness");

    public final StringPath isEyeSwelling = createString("isEyeSwelling");

    public final StringPath isFeelTired = createString("isFeelTired");

    public final StringPath isFeverAssocated = createString("isFeverAssocated");

    public final StringPath isFeverComeAndGo = createString("isFeverComeAndGo");

    public final StringPath isFits = createString("isFits");

    public final StringPath isoutOfBreath = createString("isoutOfBreath");

    public final StringPath isTalking = createString("isTalking");

    public final StringPath isVaginalDischarge = createString("isVaginalDischarge");

    public final StringPath isWaterBroken = createString("isWaterBroken");

    public final StringPath kindOfBleeding = createString("kindOfBleeding");

    public final StringPath lowerEyeColor = createString("lowerEyeColor");

    public final StringPath malaria = createString("malaria");

    public final StringPath malariaDateOne = createString("malariaDateOne");

    public final StringPath malariaDateSec = createString("malariaDateSec");

    public final StringPath rbs = createString("rbs");

    public final StringPath rbsDateOne = createString("rbsDateOne");

    public final StringPath rbsDateSec = createString("rbsDateSec");

    public final StringPath secBp = createString("secBp");

    public final StringPath secHb = createString("secHb");

    public final StringPath secMalaria = createString("secMalaria");

    public final StringPath secRbs = createString("secRbs");

    public final StringPath secUltrasound = createString("secUltrasound");

    public final StringPath secUrine = createString("secUrine");

    public final StringPath SecWeight = createString("SecWeight");

    public final StringPath sputum = createString("sputum");

    public final StringPath sputumDate = createString("sputumDate");

    public final StringPath sputumTest = createString("sputumTest");

    public final StringPath talkingIrrelevantly = createString("talkingIrrelevantly");

    public final StringPath thirdBp = createString("thirdBp");

    public final StringPath thirdHb = createString("thirdHb");

    public final StringPath thirdWeight = createString("thirdWeight");

    public final StringPath toeRingsTighter = createString("toeRingsTighter");

    public final StringPath ultrasound = createString("ultrasound");

    public final StringPath ultrasoundDateOne = createString("ultrasoundDateOne");

    public final StringPath ultrasoundDateSec = createString("ultrasoundDateSec");

    public final StringPath updatedBy = createString("updatedBy");

    public final StringPath updatedDate = createString("updatedDate");

    public final StringPath upperEyeColor = createString("upperEyeColor");

    public final StringPath urine = createString("urine");

    public final StringPath urineDateOne = createString("urineDateOne");

    public final StringPath urineDateSec = createString("urineDateSec");

    public final StringPath visitDate = createString("visitDate");

    public final StringPath weight = createString("weight");

    public final StringPath weightDateFour = createString("weightDateFour");

    public final StringPath weightDateOne = createString("weightDateOne");

    public final StringPath weightDateSec = createString("weightDateSec");

    public final StringPath weightDateThird = createString("weightDateThird");

    public final StringPath whenBreathless = createString("whenBreathless");

    public final StringPath wherePain = createString("wherePain");

    public final NumberPath<Integer> wid = createNumber("wid", Integer.class);

    public final StringPath womanName = createString("womanName");

    public QPregnancyVisit(String variable) {
        super(PregnancyVisit.class, forVariable(variable));
    }

    public QPregnancyVisit(Path<? extends PregnancyVisit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPregnancyVisit(PathMetadata<?> metadata) {
        super(PregnancyVisit.class, metadata);
    }

}

