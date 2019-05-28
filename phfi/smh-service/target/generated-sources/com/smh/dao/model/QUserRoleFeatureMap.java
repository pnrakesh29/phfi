package com.smh.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUserRoleFeatureMap is a Querydsl query type for UserRoleFeatureMap
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserRoleFeatureMap extends EntityPathBase<UserRoleFeatureMap> {

    private static final long serialVersionUID = -1446209131L;

    public static final QUserRoleFeatureMap userRoleFeatureMap = new QUserRoleFeatureMap("userRoleFeatureMap");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final NumberPath<Long> featureId = createNumber("featureId", Long.class);

    public final NumberPath<Long> featureSequenceId = createNumber("featureSequenceId", Long.class);

    public final NumberPath<Long> roleId = createNumber("roleId", Long.class);

    public final DateTimePath<java.sql.Timestamp> updated_Date = createDateTime("updated_Date", java.sql.Timestamp.class);

    public final StringPath updatedBy = createString("updatedBy");

    public QUserRoleFeatureMap(String variable) {
        super(UserRoleFeatureMap.class, forVariable(variable));
    }

    public QUserRoleFeatureMap(Path<? extends UserRoleFeatureMap> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserRoleFeatureMap(PathMetadata<?> metadata) {
        super(UserRoleFeatureMap.class, metadata);
    }

}

