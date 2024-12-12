package dtos;

import java.time.LocalDateTime;

public class CitaDto {

		String dni;
		String nombre;
		String apellidos;
		String especialidad;
		LocalDateTime fechaCita;
		boolean asistencia;

		public CitaDto(String dni, String nombre, String apellidos, String especialidad, LocalDateTime fechaCita,
				boolean asistencia) {
			super();
			this.dni = dni;
			this.nombre = nombre;
			this.apellidos = apellidos;
			this.especialidad = especialidad;
			this.fechaCita = fechaCita;
			this.asistencia = asistencia;
		}

		public CitaDto() {
			super();
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public String getEspecialidad() {
			return especialidad;
		}

		public void setEspecialidad(String especialidad) {
			this.especialidad = especialidad;
		}

		public LocalDateTime getFechaCita() {
			return fechaCita;
		}

		public void setFechaCita(LocalDateTime fechaCita) {
			this.fechaCita = fechaCita;
		}

		public boolean isAsistencia() {
			return asistencia;
		}

		public void setAsistencia(boolean asistencia) {
			this.asistencia = asistencia;
		}

		@Override
		public String toString() {
			return "CitaDto [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", especialidad="
					+ especialidad + ", fechaCita=" + fechaCita + ", asistencia=" + asistencia + "]";
		}

		// Constructor, getters, setters, y métodos auxiliares (toString, etc.)
	}

