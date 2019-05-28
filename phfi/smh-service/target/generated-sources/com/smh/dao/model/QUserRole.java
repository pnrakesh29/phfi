package com.smh.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QUserRole is a Querydsl query type for UserRole
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUserRole extends EntityPathBase<UserRole> {

    private static final long serialVersionUID = -851278417L;

    public static final QUserRole userRole = new QUserRole("userRole");

    public final StringPath createdBy = createString("createdBy");

    public final DateTimePath<java.sql.Timestamp> createdDate = createDateTime("createdDate", java.sql.Timestamp.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> entityId = createNumber("entityId", Long.class);

    public final StringPath maker_checker_req = createString("maker_checker_req");

    public final StringPath name = createString("name");

    public final StringPath reason = createString("reason");

    public final StringPath role_type = createString("role_type");

    public final StringPath status = createString("status");

    public final DateTimePath<java.sql.Timestamp> updated_Date = createDateTime("updated_Date", java.sql.Timestamp.class);

    public final StringPath updatedBy = createString("updatedBy");

    public final NumberPath<Long> userRoleId = createNumber("userRoleId", Long.class);

    public QUserRole(String variable) {
        super(UserRole.class, forVariable(variable));
    }

    public QUserRole(Path<? extends UserRole> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserRole(PathMetadata<?> metadata) {
        super(UserRole.class, metadata);
    }

}

