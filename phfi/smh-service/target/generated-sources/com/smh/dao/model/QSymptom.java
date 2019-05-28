package com.smh.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QSymptom is a Querydsl query type for Symptom
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QSymptom extends EntityPathBase<Symptom> {

    private static final long serialVersionUID = 1978898843L;

    public static final QSymptom symptom = new QSymptom("symptom");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath symptomId = createString("symptomId");

    public final StringPath symptomPhrases = createString("symptomPhrases");

    public final StringPath symptomSigns = createString("symptomSigns");

    public QSymptom(String variable) {
        super(Symptom.class, forVariable(variable));
    }

    public QSymptom(Path<? extends Symptom> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSymptom(PathMetadata<?> metadata) {
        super(Symptom.class, metadata);
    }

}

