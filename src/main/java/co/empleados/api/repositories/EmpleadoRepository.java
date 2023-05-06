package co.empleados.api.repositories;

import co.empleados.api.models.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, String> {

}
