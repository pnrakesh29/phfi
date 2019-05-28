package com.smh.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QBeaconFeature is a Querydsl query type for BeaconFeature
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QBeaconFeature extends EntityPathBase<BeaconFeature> {

    private static final long serialVersionUID = 387432452L;

    public static final QBeaconFeature beaconFeature = new QBeaconFeature("beaconFeature");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> featureId = createNumber("featureId", Long.class);

    public final NumberPath<Long> featureLevel = createNumber("featureLevel", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Long> refFeatureId = createNumber("refFeatureId", Long.class);

    public final StringPath roleType = createString("roleType");

    public final StringPath status = createString("status");

    public QBeaconFeature(String variable) {
        super(BeaconFeature.class, forVariable(variable));
    }

    public QBeaconFeature(Path<? extends BeaconFeature> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBeaconFeature(PathMetadata<?> metadata) {
        super(BeaconFeature.class, metadata);
    }

}

