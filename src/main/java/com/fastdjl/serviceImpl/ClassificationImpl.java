package com.fastdjl.serviceImpl;

import ai.djl.ModelException;
import ai.djl.translate.TranslateException;
import com.fastdjl.common.inference.ClassificationInference;
import com.fastdjl.service.Classification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * ClassName: ClassificationImpl
 * Description: 分类接口实现类
 * Author: James Zow
 * Date: 2020/11/6 9:10
 * Version:
 **/
@Service
public class ClassificationImpl implements Classification {

    Logger log = LoggerFactory.getLogger(ClassificationImpl.class);

    @Override
    public String ImageClassification(String imagePath) {
        String result = "";
        ClassificationInference classificationInference = new ClassificationInference();
        try {
            result = String.valueOf(classificationInference.predict(imagePath));
            log.info(result);
        } catch (IOException e) {
            log.error(e.getMessage());
        } catch (ModelException e) {
            log.error(e.getMessage());
        } catch (TranslateException e) {
            log.error(e.getMessage());
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result;
    }
}