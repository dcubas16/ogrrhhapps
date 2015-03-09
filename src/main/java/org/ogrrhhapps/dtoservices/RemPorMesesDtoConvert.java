package org.ogrrhhapps.dtoservices;

import java.util.ArrayList;
import java.util.List;

import org.ogrrhhapps.dto.RemuneracionPorMesesDto;
import org.ogrrhhapps.entities.Remuneracion;

public class RemPorMesesDtoConvert {

	private List<Remuneracion> remuneraciones = new ArrayList<Remuneracion>();

	private List<RemuneracionPorMesesDto> remuneracionPorMesesDtos = new ArrayList<RemuneracionPorMesesDto>();;

	public RemPorMesesDtoConvert(List<Remuneracion> remuneraciones) {
		super();
		this.remuneraciones = remuneraciones;
	}

	public List<RemuneracionPorMesesDto> getRemuneracionesPorMesesDtos() {
		int indiceAnio = -1;
		for (Remuneracion remuneracion : remuneraciones) {
			indiceAnio = -1;
			for (int i = 0; i < remuneracionPorMesesDtos.size(); i++) {
				if (remuneracionPorMesesDtos.get(i).getPlaAnu() == remuneracion
						.getPlaAnu()) {
					indiceAnio = i;
				}
			}
			
			if(indiceAnio == -1) {
				remuneracionPorMesesDtos.add(new RemuneracionPorMesesDto(remuneracion.getPlaAnu()));
				indiceAnio = remuneracionPorMesesDtos.size()-1;
			}
			
			switch (remuneracion.getPlaMes()) {
			case 1:
				remuneracionPorMesesDtos.get(indiceAnio).setDuEnero(remuneracion.getTotalDu37());
				break;
			case 2:
				remuneracionPorMesesDtos.get(indiceAnio).setDuFebrero(remuneracion.getTotalDu37());	
				break;
			case 3:
				remuneracionPorMesesDtos.get(indiceAnio).setDuMarzo(remuneracion.getTotalDu37());
				break;
			case 4:
				remuneracionPorMesesDtos.get(indiceAnio).setDuAbril(remuneracion.getTotalDu37());
				break;
			case 5:
				remuneracionPorMesesDtos.get(indiceAnio).setDuMayo(remuneracion.getTotalDu37());
				break;
			case 6:
				remuneracionPorMesesDtos.get(indiceAnio).setDuJunio(remuneracion.getTotalDu37());
				break;
			case 7:
				remuneracionPorMesesDtos.get(indiceAnio).setDuJulio(remuneracion.getTotalDu37());
				break;
			case 8:
				remuneracionPorMesesDtos.get(indiceAnio).setDuAgosto(remuneracion.getTotalDu37());
				break;
			case 9:
				remuneracionPorMesesDtos.get(indiceAnio).setDuSetiembre(remuneracion.getTotalDu37());
				break;
			case 10:
				remuneracionPorMesesDtos.get(indiceAnio).setDuOctubre(remuneracion.getTotalDu37());
				break;
			case 11:
				remuneracionPorMesesDtos.get(indiceAnio).setDuNoviembre(remuneracion.getTotalDu37());
				break;
			case 12:
				remuneracionPorMesesDtos.get(indiceAnio).setDuDiciembre(remuneracion.getTotalDu37());
				break;
			}

		}

		return remuneracionPorMesesDtos;
	}

	public List<Remuneracion> getRemuneraciones() {
		return remuneraciones;
	}

	public void setRemuneraciones(List<Remuneracion> remuneraciones) {
		this.remuneraciones = remuneraciones;
	}

	public List<RemuneracionPorMesesDto> getRemuneracionPorMesesDtos() {
		return remuneracionPorMesesDtos;
	}

	public void setRemuneracionPorMesesDtos(
			List<RemuneracionPorMesesDto> remuneracionPorMesesDtos) {
		this.remuneracionPorMesesDtos = remuneracionPorMesesDtos;
	}

}
