package co.empleados.api.controllers;

import co.empleados.api.models.Empleado;
import co.empleados.api.services.EmpleadoService;
import co.empleados.api.utils.Utilidades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    @Autowired
    private Validator validator;

    /**
     * Obtiene todos los empleados.
     *
     * @return Lista de empleados.
     */
    @GetMapping()
    public List<Empleado> getAll() {
        return empleadoService.getAll();
    }

    /**
     * Crea un nuevo empleado.
     *
     * @param empleado Empleado a crear.
     * @return Empleado creado.
     */
    @PostMapping()
    public ResponseEntity<?> create(@Validated @RequestBody Empleado empleado, BindingResult result) {
        validator.validate(empleado, result);

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        Empleado empleadoCreado = empleadoService.create(empleado);

        empleadoCreado.setEdad(Utilidades.calcularTiempoTranscurrido(empleadoCreado.getFechaNacimiento()));
        empleadoCreado.setTiempoVinculacion(Utilidades.calcularTiempoTranscurrido(empleadoCreado.getFechaVinculacion()));

        return ResponseEntity.ok(empleadoCreado);
    }
}
