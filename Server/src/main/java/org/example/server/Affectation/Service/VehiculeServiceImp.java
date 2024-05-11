package org.example.server.Affectation.Service;

import lombok.AllArgsConstructor;
import org.example.server.Affectation.Mapper.VehiculeMapper;
import org.example.server.Affectation.Model.CarteGrise;
import org.example.server.Affectation.Model.Vehicule;
import org.example.server.Affectation.Repository.VehiculeRepository;
import org.example.server.Affectation.dto.CarteGriseDTO;
import org.example.server.Affectation.dto.TripDTO;
import org.example.server.Affectation.dto.VehiculeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VehiculeServiceImp  implements VehiculeService  {
    private final VehiculeRepository vehiculeRepository;
    private final VehiculeMapper vehiculeMapper;
    @Override
    public List<VehiculeDTO> getAllVehicules() {
        List<Vehicule> vehicules = (List<Vehicule>) vehiculeRepository.findAll();
        return vehicules.stream()
                .map(vehiculeMapper::toVehiculeDTO)
                .collect(Collectors.toList());
    }
    @Override
    public List<VehiculeDTO> getAvailableVehicules() {
        List<Vehicule> availableVehicles = vehiculeRepository.findAllByDisponibilite(true);
        return availableVehicles.stream()
                .map(vehiculeMapper::toVehiculeDTO)
                .collect(Collectors.toList());
    }
    @Override
    public VehiculeDTO getVehiculeById(int id) {
        Optional<Vehicule> vehiculeOptional = vehiculeRepository.findById(id);
        return vehiculeOptional.map(vehiculeMapper::toVehiculeDTO).orElse(null);
    }

    @Override
    public VehiculeDTO saveVehicule(VehiculeDTO vehiculeDTO) {
        // Convert VehiculeDTO to Vehicule entity
        Vehicule vehicule = vehiculeMapper.toVehicule(vehiculeDTO);

        CarteGrise carteGrise = vehiculeDTO.getCarteGrise();
        // Associate the Vehicule with the CarteGrise
        vehicule.setCarteGrise(carteGrise);

        // Save both Vehicule and CarteGrise entities
        vehicule = vehiculeRepository.save(vehicule);

        // Return the updated VehiculeDTO
        return vehiculeMapper.toVehiculeDTO(vehicule);
    }

    @Override
    public void deleteVehiculeById(int id) {
        vehiculeRepository.deleteById(id);
    }



}
