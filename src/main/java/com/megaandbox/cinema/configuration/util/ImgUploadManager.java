package com.megaandbox.cinema.configuration.util;


import com.megaandbox.cinema.configuration.constants.ConstFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class ImgUploadManager {
    private final ConstFile constFile;
    private final MyFileUtils myFileUtils;


    // Store 진입 메서드
    public String saveStorePic(long storeId, MultipartFile pic) {
        return savePic(constFile.getStorePic(), storeId, pic);
    }

    public void removeStoreDirectory(long storeId) {
        removeDirectory(constFile.getStorePic(), storeId);
    }

    // Movie 진입 메서드
    public String saveMenuPic(long movieId, MultipartFile pic) {
        return savePic(constFile.getMoviePic(), movieId, pic);
    }

    public void removeMenuDirectory(long movieId) {
        removeDirectory(constFile.getMoviePic(), movieId);
    }


    // event 진입 메서드
    public String saveEventPic(long eventId, MultipartFile pic) {
        return savePic(constFile.getStorePic(), eventId, pic);
    }

    public void removeEventDirectory(long eventId) {

        removeDirectory(constFile.getStorePic(), eventId);
    }


    //스틸컷 이미지 복수 저장
    public List<String> saveStillCut(long movieId, List<MultipartFile> pics) {
        List<String> fileNames = new ArrayList<>(pics.size());

        for (MultipartFile pic : pics) {
            fileNames.add(savePic(constFile.getStillCut(), movieId, pic));
        }

        return fileNames;
    }

    // 스틸컷 폴더 삭제
    public void removeReviewPics(long movieId) {
        removeDirectory(constFile.getStillCut(), movieId);
    }


    // 이미지 저장
    private String savePic(String folder, long id, MultipartFile pic) {
        String directory = makeDirectoryPath(folder, id);
        myFileUtils.makeFolders(directory);

        String randomFileName = myFileUtils.makeRandomFileName(pic);
        String savePath = directory + "/" + randomFileName;

        try {
            myFileUtils.transferTo(pic, savePath);
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "이미지 저장에 실패하였습니다."
            );
        }

        return randomFileName;
    }

    // 폴더 삭제
    private void removeDirectory(String folder, long id) {
        String directory = makeDirectoryPath(folder, id);
        myFileUtils.deleteFolder(directory, true);
    }

    // 디렉터리 경로 생성
    private String makeDirectoryPath(String folder, long id) {
        return String.format("%s/%s/%d",
                constFile.getUploadDirectory(), folder, id);
    }
}