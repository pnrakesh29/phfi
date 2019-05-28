package com.smh.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QPostpartumVisit is a Querydsl query type for PostpartumVisit
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPostpartumVisit extends EntityPathBase<PostpartumVisit> {

    private static final long serialVersionUID = -2008768750L;

    public static final QPostpartumVisit postpartumVisit = new QPostpartumVisit("postpartumVisit");

    public final StringPath babyMove = createString("babyMove");

    public final StringPath bp = createString("bp");

    public final StringPath bpDateOne = createString("bpDateOne");

    public final StringPath bpDateSec = createString("bpDateSec");

    public final StringPath carringBabyAndHerself = createString("carringBabyAndHerself");

    public final StringPath createdBy = createString("createdBy");

    public final StringPath createdDate = createString("createdDate");

    public final StringPath firstBp = createString("firstBp");

    public final StringPath firstHb = createString("firstHb");

    public final StringPath firstMalaria = createString("firstMalaria");

    public final StringPath firstUrine = createString("firstUrine");

    public final StringPath hasBleedingIncrease = createString("hasBleedingIncrease");

    public final StringPath haveBlurredVision = createString("haveBlurredVision");

    public final StringPath haveCough = createString("haveCough");

    public final StringPath haveFever = createString("haveFever");

    public final StringPath haveHeadaches = createString("haveHeadaches");

    public final StringPath hb = createString("hb");

    public final StringPath hbDateOne = createString("hbDateOne");

    public final StringPath hbDateSec = createString("hbDateSec");

    public final StringPath howLongHaveCough = createString("howLongHaveCough");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath isAbdominalPain = createString("isAbdominalPain");

    public final StringPath isAnkleDepression = createString("isAnkleDepression");

    public final StringPath isBleeding = createString("isBleeding");

    public final StringPath isBreathless = createString("isBreathless");

    public final StringPath isBurningPain = createString("isBurningPain");

    public final StringPath isConsciousness = createString("isConsciousness");

    public final StringPath isDifficultToFeed = createString("isDifficultToFeed");

    public final StringPath isEyeSwelling = createString("isEyeSwelling");

    public final StringPath isFeelTired = createString("isFeelTired");

    public final StringPath isFeverAssocated = createString("isFeverAssocated");

    public final StringPath isFeverComeAndGo = createString("isFeverComeAndGo");

    public final StringPath isFits = createString("isFits");

    public final StringPath isHearingImaginary = createString("isHearingImaginary");

    public final StringPath isoutOfBreath = createString("isoutOfBreath");

    public final StringPath isPassClotBleeding = createString("isPassClotBleeding");

    public final StringPath isTalking = createString("isTalking");

    public final StringPath isVaginalDischarge = createString("isVaginalDischarge");

    public final StringPath lowerEyeColor = createString("lowerEyeColor");

    public final StringPath lumpInBreast = createString("lumpInBreast");

    public final StringPath malaria = createString("malaria");

    public final StringPath malariaDateOne = createString("malariaDateOne");

    public final StringPath malariaDateSec = createString("malariaDateSec");

    public final StringPath noDayAfterDel = createString("noDayAfterDel");

    public final StringPath noOfClothes = createString("noOfClothes");

    public final StringPath painInBreast = createString("painInBreast");

    public final StringPath secBp = createString("secBp");

    public final StringPath secHb = createString("secHb");

    public final StringPath secMalaria = createString("secMalaria");

    public final StringPath secUrine = createString("secUrine");

    public final StringPath sputum = createString("sputum");

    public final StringPath sputumDate = createString("sputumDate");

    public final StringPath sputumTest = createString("sputumTest");

    public final StringPath talkingIrrelevantly = createString("talkingIrrelevantly");

    public final StringPath updatedBy = createString("updatedBy");

    public final StringPath updatedDate = createString("updatedDate");

    public final StringPath upperEyeColor = createString("upperEyeColor");

    public final StringPath urine = createString("urine");

    public final StringPath urineDateOne = createString("urineDateOne");

    public final StringPath urineDateSec = createString("urineDateSec");

    public final StringPath visitDate = createString("visitDate");

    public final StringPath whenBreathless = createString("whenBreathless");

    public final StringPath wherePain = createString("wherePain");

    public final NumberPath<Integer> wid = createNumber("wid", Integer.class);

    public final StringPath womanName = createString("womanName");

    public QPostpartumVisit(String variable) {
        super(PostpartumVisit.class, forVariable(variable));
    }

    public QPostpartumVisit(Path<? extends PostpartumVisit> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPostpartumVisit(PathMetadata<?> metadata) {
        super(PostpartumVisit.class, metadata);
    }

}

