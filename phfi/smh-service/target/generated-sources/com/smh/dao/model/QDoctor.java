package com.smh.dao.model;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QDoctor is a Querydsl query type for Doctor
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QDoctor extends EntityPathBase<Doctor> {

    private static final long serialVersionUID = -1483509907L;

    public static final QDoctor doctor = new QDoctor("doctor");

    public final StringPath addressMartial = createString("addressMartial");

    public final StringPath addressnatal = createString("addressnatal");

    public final StringPath advice = createString("advice");

    public final StringPath age = createString("age");

    public final StringPath assesmentstatus = createString("assesmentstatus");

    public final StringPath date = createString("date");

    public final StringPath diagonosis = createString("diagonosis");

    public final StringPath district = createString("district");

    public final StringPath doctorName = createString("doctorName");

    public final StringPath dod = createString("dod");

    public final StringPath health = createString("health");

    public final StringPath history = createString("history");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath investigations = createString("investigations");

    public final StringPath labtest = createString("labtest");

    public final StringPath lmp = createString("lmp");

    public final StringPath medication = createString("medication");

    public final StringPath obstic = createString("obstic");

    public final StringPath place = createString("place");

    public final StringPath qualification = createString("qualification");

    public final StringPath taluk = createString("taluk");

    public final StringPath village = createString("village");

    public final StringPath wid = createString("wid");

    public final StringPath womanName = createString("womanName");

    public final StringPath years = createString("years");

    public QDoctor(String variable) {
        super(Doctor.class, forVariable(variable));
    }

    public QDoctor(Path<? extends Doctor> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDoctor(PathMetadata<?> metadata) {
        super(Doctor.class, metadata);
    }

}

