package thiago.ppt3v2.logica;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import thiago.ppt3v2.logica.Cartas;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-07-02T14:53:30", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, Integer> usuarioId;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile ListAttribute<Usuario, Cartas> cartas;
    public static volatile SingularAttribute<Usuario, Integer> estrellas;

}