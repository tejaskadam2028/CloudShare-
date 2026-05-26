package cloudshareweb.cloudshareapi.controller;

import cloudshareweb.cloudshareapi.dto.ProfileDTO;
import cloudshareweb.cloudshareapi.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/register")
    public ResponseEntity<ProfileDTO> registerProfile(
            @RequestBody ProfileDTO profileDTO
    ) {

        ProfileDTO savedProfile =
                profileService.createProfile(profileDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedProfile);
    }
}