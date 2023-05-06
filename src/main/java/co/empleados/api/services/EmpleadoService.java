package co.empleados.api.services;

import co.empleados.api.models.Empleado;
import co.empleados.api.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    /**
     * Obtiene todos los empleados.
     *
     * @return Lista de empleados.
     */
    public List<Empleado> getAll() {
        return (List<Empleado>) empleadoRepository.findAll();
    }

    /**
     * Crea un nuevo empleado.
     *
     * @param empleado Empleado a crear.
     * @return Empleado creado.
     */
    public Empleado create(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }
}
