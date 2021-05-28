HOST_UID:=$(shell id -u)
HOST_GID:=$(shell id -g)

include path.mk

JOBRUNR_PROJECT := jobrunr

.PHONY: build-jobs-container
build-jobs-container:
	HOST_UID=$(HOST_UID) \
	HOST_GID=$(HOST_GID) \
	APP_PROJECT=$(JOBRUNR_PROJECT_PATH)/app \
	ENVIRONMENT_DIR=$(JOBRUNR_PROJECT_PATH)/environment \
	docker-compose -p $(JOBRUNR_PROJECT) -f environment/docker-compose.yml build

.PHONY: run-jobs-container
run-jobs-container:
	HOST_UID=$(HOST_UID) \
	HOST_GID=$(HOST_GID) \
	APP_PROJECT=$(JOBRUNR_PROJECT_PATH)/app \
	ENVIRONMENT_DIR=$(JOBRUNR_PROJECT_PATH)/environment \
	docker-compose -p $(JOBRUNR_PROJECT) -f environment/docker-compose.yml up

.PHONY: clean-jobs-container
clean-jobs-container:
	HOST_UID=$(HOST_UID) \
	HOST_GID=$(HOST_GID) \
	APP_PROJECT=$(JOBRUNR_PROJECT_PATH)/app \
	ENVIRONMENT_DIR=$(JOBRUNR_PROJECT_PATH)/environment \
	docker-compose -p $(JOBRUNR_PROJECT) -f environment/docker-compose.yml down -v